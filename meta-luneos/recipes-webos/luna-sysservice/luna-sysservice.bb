# Copyright (c) 2012-2014 LG Electronics, Inc.

SUMMARY = "Provides image manipulation, preference, timezone and ringtone services for Open webOS components"
AUTHOR = "Keith Derrick <keith.derrick@lge.com>"
SECTION = "webos/base"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

VIRTUAL-RUNTIME_ntp ?= "sntp"

DEPENDS = "luna-service2 libpbnjson qtbase uriparser libxml2 sqlite3 pmloglib json-c nyx-lib"

RDEPENDS_${PN} += "${VIRTUAL-RUNTIME_ntp}"

PV = "2.0.1-38+git${SRCPV}"
SRCREV = "94a530276e37f97e1b6cac18b1db2429ca7de8eb"

inherit webos_public_repo
inherit webos_cmake
inherit webos_system_bus
inherit pkgconfig

SRC_URI = "${OPENWEBOS_GIT_REPO_COMPLETE} \
    file://0001-replace-cjson-with-json-c.patch \
"
S = "${WORKDIR}/git"
