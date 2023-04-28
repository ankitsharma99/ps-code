package firstsession.solidprinciples;

// High level modules should not depend (tightly coupled) on low level modules. Both should depend on abstractions.

// High-level module
class VideoPlayer {
    private final Video video;

    public VideoPlayer(Video video) {
        this.video = video;
    }

    public void play() {
        video.play();
    }
}

// Low-level module
class Mp4Video implements Video {
    @Override
    public void play() {
        System.out.println("Playing MP4 video...");
    }
}

class AviVideo implements Video {
    @Override
    public void play() {
        System.out.println("Playing AVI video...");
    }
}


// Abstraction
interface Video {
    void play();
}


public class DependencyInversion {
    public static void main(String[] args) {
        Video aviVideo = new AviVideo();
        VideoPlayer videoPlayer = new VideoPlayer(aviVideo);
        videoPlayer.play();

    }
}
