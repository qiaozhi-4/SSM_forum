import com.forum.entity.Music;
import com.forum.service.IMusicService;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;
import org.jaudiotagger.tag.id3.ID3v1Tag;
import org.junit.Test;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.TagException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.IOException;

//获取配置类
@ContextConfiguration(locations = {"classpath:spring.xml"})
//规定写法
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMp3 {

    @Autowired
    private IMusicService musicService;

    @Test
    public void test1() {
        musicService.list().forEach(System.out::println);
    }


    @Test
    public void test2() throws CannotReadException, TagException, InvalidAudioFrameException, ReadOnlyFileException, IOException {
        String url = "D:\\user\\train\\java\\SSM_forum\\src\\main\\webapp\\static\\CloudMusic\\music\\Jessica,Fabolous - Fly (English Ver.).mp3";//测试数据

        MP3File mp3File = (MP3File) AudioFileIO.read(new File(url));
        AbstractID3v2Tag v2tag = mp3File.getID3v2Tag();

        String artist = v2tag.getFirst(FieldKey.ARTIST);// 歌手名
        String album = v2tag.getFirst(FieldKey.ALBUM);// 專輯名
        String songName = v2tag.getFirst(FieldKey.TITLE);// 歌名
        System.out.println("专辑: " + album); // 專輯名
        System.out.println("歌手名: " + artist); // 歌手名
        System.out.println("歌名: " + songName); // 歌名
        MP3AudioHeader header = mp3File.getMP3AudioHeader(); // mp3文件頭部信息
        int length = header.getTrackLength();
        System.out.println("歌曲時長: " + length / 60 + ":" + length % 60); // 歌曲時長

    }

    @Test
    public void test3() throws CannotReadException, TagException, InvalidAudioFrameException, ReadOnlyFileException, IOException {
        String path = "D:\\user\\train\\java\\SSM_forum\\src\\main\\webapp\\static\\CloudMusic\\music";        //要遍历的路径
        File file = new File(path);        //获取其file对象
        File[] fs = file.listFiles();    //遍历path下的文件和目录，放在File数组中
        for (File f : fs) {                    //遍历File[]数组
            if (!f.isDirectory())        //若非目录(即文件)，则打印
            {

                MP3File mp3File = (MP3File) AudioFileIO.read(f);
                AbstractID3v2Tag v2tag = mp3File.getID3v2Tag();

                String artist = v2tag.getFirst(FieldKey.ARTIST);// 歌手名
                String album = v2tag.getFirst(FieldKey.ALBUM);// 專輯名
                String songName = v2tag.getFirst(FieldKey.TITLE);// 歌名
                MP3AudioHeader header = mp3File.getMP3AudioHeader(); // mp3文件頭部信息
                int length = header.getTrackLength();
                String imgUrl = "musicImg/";
                String url = "music/" + f.getName();
                int vip = 0;
                String date = length / 60 + ":" + length % 60;
                System.out.println("歌名: " + songName); // 歌名
                System.out.println("歌手名: " + artist); // 歌手名
                System.out.println("图片路径：" +imgUrl);//图片路径
                System.out.println("音乐：" +url);//音乐路径
                System.out.println("vip：" + vip);
                System.out.println("专辑: " + album); // 專輯名
                System.out.println("歌曲時長: " + date); // 歌曲時長

                musicService.save(new Music(null,songName,artist,imgUrl,url,vip,album,date));
            }

        }
    }


}
