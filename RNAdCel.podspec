require 'json'

package = JSON.parse(File.read(File.join(__dir__, 'package.json')))
version = package['version']

Pod::Spec.new do |s|
  s.name                   = 'RNAdCel'
  s.version                = package['version']
  s.summary                = 'AdCel plugin. This plugin allows you to show ads in your app.'
  s.homepage               = 'https://adcel.co'
  s.license                = package['license']
  s.author                 = 'AdCel'
  s.platforms              = { :ios => '9.0' }
  s.source                 = { :http => 'https://s3.adcel.co/adcel-sdk/Reactnative-ads-iOS_android.zip' }
  s.source_files           = 'ios/**/*.{h,m,mm}'
  
#   s.static_framework = true
  
  s.dependency 'React'
  s.dependency 'AdCel/AdColony'
  s.dependency 'AdCel/AmazonAd'
  s.dependency 'AdCel/Applovin'
  s.dependency 'AdCel/AdMob'
  s.dependency 'AdCel/Facebook'
  s.dependency 'AdCel/MyTarget'
  s.dependency 'AdCel/MoPub'
  s.dependency 'AdCel/Smaato'
  s.dependency 'AdCel/StartApp'
  s.dependency 'AdCel/Supersonic'
  s.dependency 'AdCel/Tapjoy'
  s.dependency 'AdCel/Unity'
  s.dependency 'AdCel/Vungle'
  s.dependency 'AdCel/Yandex'
  s.dependency 'AdCel/Inhouse'
  s.dependency 'AdCel/Criteo'
  s.dependency 'AdCel/Pangle'
  s.dependency 'AdCel/InMobi'
end
