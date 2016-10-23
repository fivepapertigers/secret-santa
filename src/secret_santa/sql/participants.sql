-- src/secret_santa/sql/participants.sql
-- Participants

-- :name participants-all :? :*
-- :doc select all participants with all attributes
SELECT *
  FROM participants

-- :name participant-by-id :? :*
-- :doc get artist info by music_brainz id
SELECT *
  FROM participants
 WHERE id = :id