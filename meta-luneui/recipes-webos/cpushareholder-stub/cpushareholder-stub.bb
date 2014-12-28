# Copyright (c) 2012-2013 LG Electronics, Inc.

SUMMARY = "Stubbed implementation of the webOS CPU shares scripts"
SECTION = "webos/base"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

RPROVIDES_${PN} = "cpushareholder"

PV = "2.0.1-2+git${SRCPV}"
SRCREV = "3a3169ca2863ce7e159feb86dff2651a7e02ef2e"

inherit webos_public_repo
inherit webos_cmake
inherit allarch
inherit pkgconfig

SRC_URI = "${OPENWEBOS_GIT_REPO_COMPLETE}"
S = "${WORKDIR}/git"
