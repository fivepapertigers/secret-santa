-- src/secret_santa/sql/participants.sql
-- Participants

-- :name participants-with-excludes :? :*
-- :doc select all participants with all attributes
SELECT id, name, email, exclude_id, has
  FROM participants
  LEFT JOIN excludes ON participants.id=excludes.participant_id

-- :name participant-by-id :? :*
-- :doc get artist info by music_brainz id
SELECT *
  FROM participants
  WHERE id = :id