using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Connection.Service.RNConnectionService
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNConnectionServiceModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNConnectionServiceModule"/>.
        /// </summary>
        internal RNConnectionServiceModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNConnectionService";
            }
        }
    }
}
