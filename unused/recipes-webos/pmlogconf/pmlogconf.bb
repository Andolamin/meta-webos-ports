# Copyright (c) 2012-2013 LG Electronics, Inc.

SUMMARY = "Open webOS logging daemon configuration"
SECTION = "webos/base"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

PV = "2.0.0-16+git${SRCPV}"
SRCREV = "e71ed6261d75e059762ab86575ae75e9cd89afeb"

inherit webos_public_repo
inherit webos_cmake
inherit allarch

SRC_URI = "${OPENWEBOS_GIT_REPO_COMPLETE}"
S = "${WORKDIR}/git"
