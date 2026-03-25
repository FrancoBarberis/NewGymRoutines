-- V1__init.sql (mínimo para Auth + Exercises + Workouts)
create table users (
  id uuid primary key,
  email varchar(255) not null unique,
  hashed_password varchar(255) not null,
  nombre varchar(100) not null
);

create table exercises (
  id uuid primary key,
  name varchar(120) not null,
  muscle_group varchar(40) not null,
  unique(name, muscle_group)
);

create table workouts (
  id uuid primary key,
  user_id uuid not null references users(id),
  name varchar(120) not null
);

create table workout_exercises (
  workout_id uuid references workouts(id),
  exercise_id uuid references exercises(id),
  sets integer not null,
  reps integer not null,
  primary key (workout_id, exercise_id)
);