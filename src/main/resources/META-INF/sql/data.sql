insert into authors (id, firstName, lastName) values (-1, 'adam', 'nowak'), (-2, 'janusz', 'kowalski');
insert into publishers (id, name) values (-1, 'nazwa');
insert into books (id, description, rating, title, publisher_id) values (-1, 'abc', 4, 'cba', -1), (-2, 'def', 5, 'fed', -1);
insert into books_authors (books_id, authors_id) values (-1, -1), (-2, -2);