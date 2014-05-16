SUMMARY = "Phone Simulator for modem testing"
SECTION = "devel"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=eb723b61539feef013de476e68b5c50a"

DEPENDS += "qtbase qtscript qtxmlpatterns"

SRC_URI = "https://www.kernel.org/pub/linux/network/ofono/phonesim-${PV}.tar.xz"
SRC_URI[md5sum] = "9aa7403fb0435d89d59dd32ad27f37ca"
SRC_URI[sha256sum] = "1ce9f5fa99a24bf69baa8a8ef140a54c27624764558dcffbf9caf5be1b83d82a"

SRC_URI += "file://0001-Port-to-qt5.patch"

inherit autotools
inherit qmake5_paths

do_configure_append() {
    sed -i -e s:/usr/bin/qt5/uic:${OE_QMAKE_PATH_EXTERNAL_HOST_BINS}/uic:g ${S}/Makefile
    sed -i -e s:/usr/bin/qt5/moc:${OE_QMAKE_PATH_EXTERNAL_HOST_BINS}/moc:g ${S}/Makefile
}
