__author__ = 'nathanlrf'

#! /usr/bin/env python
# A system information gathering script

import subprocess

uname = "uname"
uname_arg = "-a"
print "Gathering sys info with %s command:\n" % uname
subprocess.call([uname, uname_arg])

diskspace = "df"
diskspace_arg = "-h"
print "Gathering disk space info %s command :\n" % diskspace
subprocess.call([diskspace, diskspace_arg])


def tmp_space():
    path = "/tmp"
    print "space used in %s dir is:\n" % path
    subprocess.call(["df", "-h", path])


def main():
    tmp_space()

if __name__ == "__main__":
    main()

