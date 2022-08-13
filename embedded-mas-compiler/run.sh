#! /bin/sh
../../apache-ant-1.10.12/bin/ant ThingComp
cd ./ThingComp/
java ThingComp ../examples/smart-home.thing
cd ..
