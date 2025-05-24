package utils;

import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.File;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class VideoRecorder {
    private ScreenRecorder screenRecorder;

    public void startRecording(String fileName) throws Exception {
        File file = new File("test-recordings");
        file.mkdirs();
        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice().getDefaultConfiguration();
        screenRecorder = new ScreenRecorder(gc, null,
                new Format(MediaTypeKey, MediaType.VIDEO, MimeTypeKey, MIME_AVI,
                        EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        DepthKey, 24, FrameRateKey, new Rational(15, 1),
                        QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
                null, null, file);
        screenRecorder.start();
    }

    public void stopRecording() throws Exception {
        screenRecorder.stop();
    }
}