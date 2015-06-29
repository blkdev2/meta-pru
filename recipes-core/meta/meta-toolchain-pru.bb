SUMMARY = "PRU SDK toolchain"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

require recipes-core/meta/meta-toolchain.bb

TOOLCHAIN_HOST_TASK += "nativesdk-packagegroup-pru-toolchain-host"
TOOLCHAIN_TARGET_TASK += "packagegroup-pru-toolchain-target"

SDK_SUFFIX = "toolchain-pru"