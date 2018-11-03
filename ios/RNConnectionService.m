
#import "RNConnectionService.h"

@implementation RNConnectionService

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD( showCallUI)
{
    return;
}

RCT_EXPORT_METHOD(stopRingtone)
{
    return;
}

@end
