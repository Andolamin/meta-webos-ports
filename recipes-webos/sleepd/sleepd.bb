# Copyright (c) 2012-2013 LG Electronics, Inc.

SUMMARY = "Sleep scheduling policy daemon"
SECTION = "webos/base"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

DEPENDS = "nyx-lib luna-service2 cjson libxml2 sqlite3 glib-2.0 powerd"

WEBOS_VERSION = "1.1.1-17_4ab6b04c73d0c7c375fb9efc1107680ab7927d35"

inherit webos_component
inherit webos_public_repo
inherit webos_enhanced_submissions
inherit webos_cmake
inherit webos_daemon
inherit webos_system_bus

SRC_URI = "${OPENWEBOS_GIT_REPO_COMPLETE}"
S = "${WORKDIR}/git"
