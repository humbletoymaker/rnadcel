#!/bin/sh

cd "$( dirname "${BASH_SOURCE[0]}" )"

rm -rf ../../react-native-adcel_copy
/bin/cp -f -R -p ../../react-native-adcel ../../react-native-adcel_copy
rm -rf ../../react-native-adcel_copy/Example

cd "./AdCelReactNativeDemo"

npm install

rm ./node_modules/react-native-adcel
mv ../../../react-native-adcel_copy ./node_modules/react-native-adcel

react-native unlink react-native-adcel
react-native link react-native-adcel

cd "./ios"

pod deintegrate
pod update