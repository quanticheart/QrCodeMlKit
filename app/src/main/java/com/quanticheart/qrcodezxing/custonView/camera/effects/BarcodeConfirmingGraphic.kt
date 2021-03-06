/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.quanticheart.qrcodezxing.custonView.camera.effects

import android.graphics.Canvas
import android.graphics.Path
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode
import com.quanticheart.qrcodezxing.custonView.camera.GraphicOverlay

/** Guides user to move camera closer to confirm the detected barcode.  */
internal class BarcodeConfirmingGraphic(
    overlay: GraphicOverlay,
    private val barcode: FirebaseVisionBarcode
) :
    BarcodeGraphicBase(overlay) {

    override fun draw(canvas: Canvas) {
        super.draw(canvas)

        // Draws a highlighted path to indicate the current progress to meet size requirement.
        val path = Path()

        path.moveTo(boxRect.left, boxRect.top + boxRect.height() )
        path.lineTo(boxRect.left, boxRect.top)
        path.lineTo(boxRect.left + boxRect.width() , boxRect.top)

        path.moveTo(boxRect.right, boxRect.bottom - boxRect.height())
        path.lineTo(boxRect.right, boxRect.bottom)
        path.lineTo(boxRect.right - boxRect.width(), boxRect.bottom)
        canvas.drawPath(path, pathPaint)
    }
}
