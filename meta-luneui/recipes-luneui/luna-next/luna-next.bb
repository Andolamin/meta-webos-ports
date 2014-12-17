DESCRIPTION = "Next generation webOS UI which meant to be a complete replacement for \
LunaSysMgr/WebAppMgr and is completely based on well known open source technologies like \
Qt 5 and Wayland."
LICENSE = "GPL-3.0 & Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "qtbase qtdeclarative qtwayland luna-sysmgr-common"

SRC_URI = "${WEBOS_PORTS_GIT_REPO_COMPLETE}"
S = "${WORKDIR}/git"

PV = "0.1.0-26+git${SRCPV}"
SRCREV = "718e1f8a1373d2ce1853d5d418047db98e004f78"

inherit pkgconfig
inherit webos_ports_repo
inherit webos_system_bus
inherit webos_cmake_qt5
inherit systemd

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "luna-next.service"

do_install_append() {
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${S}/files/systemd/luna-next.service ${D}${systemd_unitdir}/system/
}

RDEPENDS_${PN} = "luna-next-conf xkeyboard-config"

FILES_${PN} += "${OE_QMAKE_PATH_QML}/LunaNext"
FILES_${PN}-dbg += " \
    ${OE_QMAKE_PATH_QML}/LunaNext/*/.debug \
    ${OE_QMAKE_PATH_QML}/LunaNext/*/*/.debug"
