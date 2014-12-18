# Copyright (c) 2012-2013 LG Electronics, Inc.

SUMMARY = "Open webOS logging control application"
SECTION = "webos/base"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

DEPENDS = "pmloglib"

PV = "3.0.0-17+git${SRCPV}"
SRCREV = "6ce8ed0938006ed7d1fb3235cb65bc64b713705a"

inherit webos_public_repo
inherit webos_cmake
inherit pkgconfig

SRC_URI = "${OPENWEBOS_GIT_REPO_COMPLETE}"
S = "${WORKDIR}/git"
