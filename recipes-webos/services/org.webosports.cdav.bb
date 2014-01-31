SUMMARY = "Node.js service to provide synergy connector for CardDav and CalDav"
SECTION = "webos/services"
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d32239bcb673463ab874e80d47fae504"

inherit webos_public_repo
inherit webos_arch_indep
inherit webos_system_bus

PV = "0.2.3+gitr${SRCPV}"

SRCREV = "f141b9560e0999bd2ef1a9c2985f96d9f0045aa6"
SRC_URI = "git://github.com/webOS-ports/org.webosports.service.contacts.carddav;protocol=git;branch=master"
S = "${WORKDIR}/git"

WEBOS_SYSTEM_BUS_FILES_LOCATION = "${S}/service/sysbus"

do_install() {
    # the service itself
    install -d ${D}${webos_servicesdir}/org.webosports.cdav.service
    cp -rv ${S}/service/* ${D}${webos_servicesdir}/org.webosports.cdav.service
    rm -rf ${D}${webos_servicesdir}/org.webosports.cdav.service/configuration

    # db8 kinds and permissions
    install -d ${D}${webos_sysconfdir}/db/kinds
    install -d ${D}${webos_sysconfdir}/db/permissions
    cp -vrf ${S}/service/configuration/db/kinds/* ${D}${webos_sysconfdir}/db/kinds/
    cp -vrf ${S}/service/configuration/db/permissions/* ${D}${webos_sysconfdir}/db/permissions/

    # account templates
    install -d ${D}${webos_accttemplatesdir}/org.webosports.cdav
    cp -vrf ${S}/accounts-enyo/* ${D}${webos_accttemplatesdir}/org.webosports.cdav

    install -d ${D}${webos_accttemplatesdir}/org.webosports.cdav.account.google.contacts
    cp -vrf ${S}/accounts-google-contacts/* ${D}${webos_accttemplatesdir}/org.webosports.cdav.account.google.contacts

    # account creation application
    install -d ${D}${webos_applicationsdir}/org.webosports.cdav.app
    cp -rv ${S}/app-enyo/* ${D}${webos_applicationsdir}/org.webosports.cdav.app/
}

FILES_${PN} += "${webos_applicationsdir} ${webos_servicesdir} ${webos_accttemplatesdir}"