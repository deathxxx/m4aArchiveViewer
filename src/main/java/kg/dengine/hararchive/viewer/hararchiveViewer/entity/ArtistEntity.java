package kg.dengine.hararchive.viewer.hararchiveViewer.entity;

import javax.persistence.*;

@Entity
@Table(name = "artist", schema = "allsong", catalog = "Test")
public class ArtistEntity {
    private Long artistId;
    private String displayArtist;

    @Id
    @Column(name = "artist_id")
    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    @Basic
    @Column(name = "display_artist")
    public String getDisplayArtist() {
        return displayArtist;
    }

    public void setDisplayArtist(String displayArtist) {
        this.displayArtist = displayArtist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArtistEntity that = (ArtistEntity) o;

        if (artistId != null ? !artistId.equals(that.artistId) : that.artistId != null) return false;
        if (displayArtist != null ? !displayArtist.equals(that.displayArtist) : that.displayArtist != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = artistId != null ? artistId.hashCode() : 0;
        result = 31 * result + (displayArtist != null ? displayArtist.hashCode() : 0);
        return result;
    }
}
