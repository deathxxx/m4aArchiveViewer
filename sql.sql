INSERT INTO allsong.artist
  SELECT artist_id, display_artist
  FROM allsong."all" WHERE NOT EXISTS (
    SELECT 1 FROM allsong.artist
    WHERE allsong."all".artist_id = allsong.artist.artist_id
  );

INSERT INTO allsong.artist
select artist_id
from allsong."all"
GROUP BY artist_id
ORDER BY artist_id;

UPDATE artist
  set display_artist = "all".display_artist
from "all"

where "all".artist_id = artist.artist_id;