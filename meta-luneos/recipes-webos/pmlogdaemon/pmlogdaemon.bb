# Copyright (c) 2012-2014 LG Electronics, Inc.

SUMMARY = "Open webOS logging daemon"
AUTHOR = "Gayathri Srinivasan <gayathri.srinivasan@lge.com>"
SECTION = "webos/base"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

DEPENDS = "pmloglib zlib glib-2.0 librdx libpbnjson pmloglib-private luna-service2"
# show_disk_usage.sh script uses mktemp, find, xargs, and du, all of which are
# provided by busybox.
RDEPENDS_${PN} = "busybox"

PV = "3.0.0-120+git${SRCPV}"
SRCREV = "bb96721e299049aa4486331e71d4c91b52a287ed"

EXTRA_OECMAKE += "-DENABLE_LOGGING:BOOL='YES'"

inherit webos_public_repo
inherit webos_cmake
inherit pkgconfig
inherit webos_system_bus

SRC_URI = "${OPENWEBOS_GIT_REPO_COMPLETE}"
S = "${WORKDIR}/git"

FILES_${PN} += "${datadir}/PmLogDaemon"
