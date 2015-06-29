SUMMARY = "User-space interface library for uio_pruss PRU driver."
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"
ALLOW_EMPTY_${PN} = "1"

SRC_URI = "git://github.com/kaukeb/prussdrv.git;protocol=https;branch=master"
SRCREV = "86b22748cfa84287875ded62081fb794e62063fd"

S = "${WORKDIR}/git"

do_compile() {
   oe_runmake
}

do_install() {
   install -d ${D}${libdir}
   install ${S}/libprussdrv.a ${D}${libdir}/libprussdrv.a

   install -d ${D}${includedir}
   install ${S}/prussdrv.h ${D}${includedir}/prussdrv.h
   install ${S}/pruss_intc_mapping.h ${D}${includedir}/pruss_intc_mapping.h
}
