# Copyright (c) 2012-2014 LG Electronics, Inc.

SUMMARY = "Sleep scheduling policy daemon"
AUTHOR = "Sapna Todwal <sapna.todwal@lge.com>"
SECTION = "webos/base"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

DEPENDS = "nyx-lib luna-service2 json-c libxml2 sqlite3 glib-2.0 powerd"

PV = "1.1.1-30+git${SRCPV}"
SRCREV = "243b82b5c677a826424e84d471706af846acec2c"

inherit webos_ports_fork_repo
inherit webos_cmake
inherit pkgconfig
inherit webos_system_bus

SRC_URI = "${WEBOS_PORTS_GIT_REPO_COMPLETE} \
    file://0001-replace-cjson-with-json-c.patch \
"
S = "${WORKDIR}/git"
