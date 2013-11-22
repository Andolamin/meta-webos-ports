# Copyright (c) 2013 LG Electronics, Inc.

SUMMARY = "AllJoyn Open Source Project"
DESCRIPTION = "open-source software framework developed by Qualcomm Innovation Center to enable peer-to-peer communication"
SECTION = "libs/network"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://alljoyn_core/NOTICE.txt;md5=c80318e464aeed6671097df52cae13eb"

DEPENDS = "openssl xulrunner"

SRC_URI = "https://www.alljoyn.org/sites/default/files/resources/alljoyn-${PV}-src.tgz;name=alljoyncore \
           file://alljoyn.pc \
           file://alljoyn.upstart \
           file://alljoyn.conf \
           file://makefile-fixes-for-compiling-in-OE.patch"

SRC_URI[alljoyncore.md5sum] = "2d6274410ab23fcb17eb1d7a8bcc4e76"
SRC_URI[alljoyncore.sha256sum] = "be7d50c7f1696908012421a3fb7addd588c8c7427125915ec07f6b8d59b07b0b"

S = "${WORKDIR}/alljoyn-${PV}-src"

export GECKO_BASE = "${STAGING_INCDIR}/xulrunner-sdk"

# The CPU and OS variables are used to set the build output directory in AllJoyn Makefile
EXTRA_OEMAKE = "CPU=x86 OS=linux VARIANT=release"

#
# Disable QA insanity checks that don't apply to this component
#
# ldflags: No GNU_HASH in the elf binary
INSANE_SKIP_${PN} += "ldflags"

do_install() {
    install -d ${D}${libdir}
    oe_libinstall -so -C ${S}/build/dist/lib liballjoyn      ${D}${libdir}

    install -d ${D}${sbindir}
    install -v ${S}/build/dist/bin/alljoyn-daemon ${D}${sbindir}

    install -d ${D}${includedir}/qcc/posix
    install -v -m 644 ${S}/build/dist/inc/qcc/posix/*.h ${D}${includedir}/qcc/posix
    install -v -m 644 ${S}/build/dist/inc/qcc/*.h ${D}${includedir}/qcc

    install -d ${D}${includedir}/alljoyn
    install -v -m 644 ${S}/build/dist/inc/alljoyn/*.h ${D}${includedir}/alljoyn

    install -d ${D}${webos_browserpluginsdir}
    install -v ${S}/build/dist/js/lib/libnpalljoyn.so ${D}${webos_browserpluginsdir}

    install -d ${D}${webos_pkgconfigdir}
    install -v -m 644 ${WORKDIR}/alljoyn.pc ${D}${webos_pkgconfigdir}

    install -d ${D}${webos_upstartconfdir}
    install -v -m 644 ${WORKDIR}/alljoyn.upstart ${D}${webos_upstartconfdir}/alljoyn

    install -d ${D}${sysconfdir}/init
    install -v -m 644 ${WORKDIR}/alljoyn.conf ${D}${sysconfdir}/init/
}

# The results of do_compile() are already stripped
INHIBIT_PACKAGE_STRIP = "1"

# Note that plugins are always unversioned.
FILES_${PN} += "${webos_browserpluginsdir}/*.so"
