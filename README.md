
# react-native-connection-service

## Getting started

`$ npm install react-native-connection-service --save`

### Mostly automatic installation

`$ react-native link react-native-connection-service`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-connection-service` and add `RNConnectionService.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNConnectionService.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNConnectionServicePackage;` to the imports at the top of the file
  - Add `new RNConnectionServicePackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-connection-service'
  	project(':react-native-connection-service').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-connection-service/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-connection-service')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNConnectionService.sln` in `node_modules/react-native-connection-service/windows/RNConnectionService.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Connection.Service.RNConnectionService;` to the usings at the top of the file
  - Add `new RNConnectionServicePackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNConnectionService from 'react-native-connection-service';

// TODO: What to do with the module?
RNConnectionService;
```
  