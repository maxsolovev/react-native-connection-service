
import { NativeModules } from 'react-native';

const RNConnectionService = NativeModules.RNConnectionService

export const RNConnectionServiceModule = {
    showCallUI: RNConnectionService.showCallUI,
    stopRingtone: RNConnectionService.stopRingtone
}