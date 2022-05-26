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

import java.io.File;
import java.io.IOException;

public class TestMp3 {


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
        System.out.println("歌曲時長: " + length / 60 + ":" + length % 60 ); // 歌曲時長

    }
}
