# Copyright (c) 2012-2013 LG Electronics, Inc.

SUMMARY = "Provides image manipulation, preference, timezone and ringtone services for Open webOS components"
SECTION = "webos/base"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

DEPENDS = "luna-service2 libpbnjson qtbase uriparser libxml2 sqlite3"

RDEPENDS_${PN} = "sntp"

# corresponds to tag submissions/6
SRCREV = "eb716d1311c36bec22ed5bcd2ae057d6262f4051"
PV = "2.0.1-6"

inherit webos_component
inherit webos_public_repo
inherit webos_enhanced_submissions
inherit webos_cmake
inherit webos_system_bus
inherit webos_machine_dep
inherit webos_daemon

WEBOS_GIT_TAG = "submissions/${WEBOS_SUBMISSION}"
SRC_URI = "${OPENWEBOS_GIT_REPO_COMPLETE}"
S = "${WORKDIR}/git"
