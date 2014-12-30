# Copyright (c) 2012-2013 LG Electronics, Inc.

SUMMARY = "Stubbed implementation of the webOS Remote Diagnostics Utilities"
SECTION = "webos/base"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

RPROVIDES_${PN} = "rdx-utils"

PV = "2.0.0-1+git${SRCPV}"
SRCREV = "51341059f7e53bbff150c728a2ac09daf90edf55"

inherit webos_public_repo
inherit webos_cmake
inherit allarch
inherit pkgconfig

SRC_URI = "${OPENWEBOS_GIT_REPO_COMPLETE}"
S = "${WORKDIR}/git"
