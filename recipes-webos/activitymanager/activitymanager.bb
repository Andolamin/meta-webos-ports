# Copyright (c) 2012-2013 LG Electronics, Inc.

DESCRIPTION = "Open webOS component to manage all running activities."
LICENSE = "Apache-2.0"
SECTION = "webos/dameons"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

DEPENDS = "luna-service2 db8 boost openssl glib-2.0 pmloglib nyx-lib"

WEBOS_VERSION = "3.0.0-120_e7cda7e6b6e4d5b8962724a187e9d074ec3a207d"

inherit webos_component
inherit webos_public_repo
inherit webos_enhanced_submissions
inherit webos_cmake
inherit webos_system_bus
inherit webos_daemon
inherit webos_machine_impl_dep

SRC_URI = "${OPENWEBOS_GIT_REPO_COMPLETE}"
S = "${WORKDIR}/git"
