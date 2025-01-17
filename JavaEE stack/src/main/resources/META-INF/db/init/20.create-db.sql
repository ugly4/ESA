-- start ESA_ALBUMS
alter table ESA_ALBUMS add constraint if not exists FK_ESA_ALBUMS_ARTISTS foreign key (ARTIST_ID) references ESA_ARTISTS(ID)
-- end ESA_ALBUMS
-- start ESA_SONGS
alter table ESA_SONGS add constraint if not exists FK_ESA_SONGS_ARTISTS foreign key (ARTIST_ID) references ESA_ARTISTS(ID)
alter table ESA_SONGS add constraint if not exists FK_ESA_SONGS_ALBUMS foreign key (ALBUM_ID) references ESA_ALBUMS(ID)
-- end ESA_SONGS