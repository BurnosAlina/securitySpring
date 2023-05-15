INSERT INTO user_details (first_name, last_name, email, password)
VALUES
    ('John', 'Doe', 'john.doe@example.com', '{bcrypt}$2a$10$m2jLZgmkHwrOYFwNt/VeTuJ5uVBTbjycS8Ew8EemYkJLXWOepX4YO'),
    ('Jane', 'Doe', 'jane.doe@example.com', '{bcrypt}$2a$10$IfZyl2iNOsTm1O6bepCzAuCOgGjFX0GjgP8mki0HrGb3N1ATlr1YG'),
    ('Bob', 'Smith', 'bob.smith@example.com', '{bcrypt}$2a$10$cISHfoQVpWDIdATS8zbsheuq9/eB.FjHs8vcdncQs8.mNz1sYq7pC');

INSERT INTO user_role (id, name, description)
VALUES
    (1, 'Admin', 'Administrator role'),
    (2, 'Manager', 'Manager role'),
    (3, 'User', 'Regular user role');

INSERT INTO user_details_roles (user_details_id, roles_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);