# Copyright (c) 2012-2013 LG Electronics, Inc.

DESCRIPTION = "Open webOS component to manage all running activities."
AUTHOR = "Ludovic Legrand <ludovic.legrand@lge.com>"
LICENSE = "Apache-2.0"
SECTION = "webos/dameons"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

DEPENDS = "luna-service2 db8 boost openssl glib-2.0 pmloglib nyx-lib"

PV = "3.0.0-123+git${SRCPV}"
SRCREV = "36477172ae0857eb02f3af2e54860a237afbd660"

inherit webos_public_repo
inherit webos_cmake
inherit webos_system_bus
inherit pkgconfig
inherit webos_machine_impl_dep

SRC_URI = "${OPENWEBOS_GIT_REPO_COMPLETE} \
    file://0001-Fix-build-with-newer-boost-1.58.0.patch \
"
S = "${WORKDIR}/git"

CXXFLAGS += "-fpermissive"
