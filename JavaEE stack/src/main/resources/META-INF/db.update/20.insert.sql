
insert into ESA_ARTISTS (id, name)
values  ('829cc9bc-3736-48e0-8822-d39193ddf5f4', 'Queen'),
        ('18fa8bd4-4261-420a-8afc-50e473833047', 'Britney Spears'),
        ('885216cc-5671-4335-880b-094129cda9c0', 'Bruno Mars');

insert into ESA_ALBUMS (id, name, year, genre, label, artist_id)
VALUES  (56503e9b-8888-42f3-9cee-ff7ede1d4be0, 'A Night at the Opera', 1975, 'Progress pop', 'Rockfield', '829cc9bc-3736-48e0-8822-d39193ddf5f4'),
        (d88b8a81-9a20-4f1b-9fe3-d5da03070253, 'Oops!...I Did It Again', 2000, 'Pop', 'Jive', '18fa8bd4-4261-420a-8afc-50e473833047'),
        (44804c5f-6860-4919-8e0b-6c89516ccc30, 'Doo-Wops & Hooligans', 2011, 'Pop', 'Atlantic',	'885216cc-5671-4335-880b-094129cda9c0');

INSERT INTO ESA_SONGS (id, name, duration, explicit_content, album_id, artist_id)
VALUES  ('1a93723b-f15b-4da5-8856-5468f6a3480c', 'Bohemian Rhapsody', 355, false, '56503e9b-8888-42f3-9cee-ff7ede1d4be0', '829cc9bc-3736-48e0-8822-d39193ddf5f4'),
        ('d183c587-248d-4c04-b9b2-fd979baff86e', 'Oops!...I Did it Again', 210,	false,	'd88b8a81-9a20-4f1b-9fe3-d5da03070253', '18fa8bd4-4261-420a-8afc-50e473833047'),
        ('cac4db35-b315-4fb7-b87a-da1f9e4e27dd', 'The Lazy Song', 190,	false,	'44804c5f-6860-4919-8e0b-6c89516ccc30', '885216cc-5671-4335-880b-094129cda9c0');