DESCRIPTION = "TI PRU Code Generation Tools"
SECTION = "devel"
LICENSE = "TI"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=b6311962635a4f15630e36ec2d875eca"

S = "${WORKDIR}/ti-cgt-pru_${PV}"

SRC_URI = "file://ti-cgt-pru_${PV}.tar.bz2"

inherit nativesdk

do_install() {
    # Binary tools
    install -d ${D}${bindir}
    install -d ${D}${datadir}/ti/cgt-pru/bin
    for binfile in ${S}/bin/*; do
        install -m 755 ${binfile} ${D}${bindir}
        install -m 755 ${binfile} ${D}${datadir}/ti/cgt-pru/bin
    done

    # PRU headers
    install -d ${D}${datadir}/ti/cgt-pru/include
    for includefile in ${S}/include/*; do
        install -m 644 ${includefile} ${D}${datadir}/ti/cgt-pru/include
    done

    # PRU libs
    install -d ${D}${datadir}/ti/cgt-pru/lib
    for libfile in ${S}/lib/*.a; do
        install -m 644 ${libfile} ${D}${datadir}/ti/cgt-pru/lib
    done
    for libfile in ${S}/lib/*.cmd; do
        install -m 644 ${libfile} ${D}${datadir}/ti/cgt-pru/lib
    done
    for libfile in ${S}/lib/*.lib; do
        install -m 644 ${libfile} ${D}${datadir}/ti/cgt-pru/lib
    done

    #manpages
    install -d ${D}${datadir}/man/man1
    for manfile in ${S}/man/man1/*; do
        install -m 644 ${manfile} ${D}${datadir}/man/man1
    done
}

FILES_${PN} += "${datadir}/ti/*"
FILES_${PN}-dbg += "${datadir}/ti/cgt-pru/bin/.debug"

