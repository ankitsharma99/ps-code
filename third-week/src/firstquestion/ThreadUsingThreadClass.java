package firstquestion;

class DownloadManager extends Thread {
    private String fileUrl;

    public DownloadManager (String fileUrl) {
        this.fileUrl = fileUrl;
    }
    @Override
    public void run() {
        System.out.println("Downloading file with url: " + fileUrl);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("File with url: " + fileUrl + " downloaded successfully");
    }
}
public class ThreadUsingThreadClass {
    public static void main(String[] args) {
        String[] fileUrls = {"https://ankitsharma.com/resume.txt", "https://icc.com/odi/rankings-2023.txt"};

        for(String fileUrl: fileUrls) {
            DownloadManager downloadManager = new DownloadManager(fileUrl);
            downloadManager.start();
        }
        
    }
}
