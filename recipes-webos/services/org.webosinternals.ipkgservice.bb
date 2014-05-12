SUMMARY = "Package management service for Open webOS"
SECTION = "webos/services"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=eb723b61539feef013de476e68b5c50a"

DEPENDS = "luna-service2 glib-2.0 mjson"

inherit webos_component
inherit webos_public_repo
inherit webos_cmake
inherit webos_daemon
inherit webos_system_bus

WEBOS_COMPONENT_VERSION = "2.0.0"
PV = "${WEBOS_COMPONENT_VERSION}+git${SRCPV}"
WEBOS_SUBMISSION = "0"

SRCREV = "633d567ce2e55f328c3f0dc1e5034923394a9eae"
SRC_URI = "git://github.com/webOS-ports/preware;protocol=git;branch=master"
S = "${WORKDIR}/git/oe-service"

pkg_postinst_${PN}() {
    #!/bin/sh -e

    # Make sure we're only executed on the device
    if [ x"$D" = "x" ]; then
        APPS=/media/cryptofs/apps

        # Create the opkg config and database areas
        mkdir -p $APPS/${sysconfdir}/opkg $APPS/${localstatedir}/lib/opkg/cache

        # We provide an empty status file to satisfy the ipkgservice
        touch $APPS/${localstatedir}/lib/opkg/status

        # Remove all list database cache files
        rm -f $APPS/${localstatedir}/lib/opkg/lists/*

        # Set up the architecture configuration file
        rm -f $APPS/${sysconfdir}/opkg/arch.conf
        cp ${sysconfdir}/opkg/arch.conf $APPS/${sysconfdir}/opkg/arch.conf

        # Install webosports all-arch feeds
        echo "src/gz webosports http://feeds.webos-ports.org/webos-ports/all" > $APPS/${sysconfdir}/opkg/webos-ports.conf
    else
        exit 1
    fi
}
