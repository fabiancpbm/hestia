#! /bin/sh
../../apache-ant-1.10.12/bin/ant ThingComp
cd ./target/ThingComp/
java ThingComp ../../test/examples/smart-home.thing
cd ..
