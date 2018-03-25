package com.coderdeer.contactmessaging

import java.util.*

/**
 * Created by qureshi on 25/03/18.
 */

fun ClosedRange<Int>.random() =
        Random().nextInt(endInclusive - start) +  start
