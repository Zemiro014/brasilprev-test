INSERT INTO public.adress_tab
(id, city, country, "number", state, street, zipcode)
VALUES('2fcc8fec-b7b4-11ec-b2c6-23509029e07d', 'São Leopoldo', 'Brasil', '1055', 'RS', 'Centro', '93010004');

INSERT INTO public.adress_tab
(id, city, country, "number", state, street, zipcode)
VALUES('82f54c68-b7b4-11ec-be88-130b4cbe5ca0', 'Novo Hamburgo', 'Brasil', '1870', 'RS', 'Centro', '93010003');

INSERT INTO public.adress_tab
(id, city, country, "number", state, street, zipcode)
VALUES('6689e53e-b7b4-11ec-8d99-e3bbaef2ae15', 'Porto Alegre', 'Brasil', '714', 'RS', 'Centro', '93010005');

INSERT INTO public.client_tab
(id, clientname, cpf, email, adress_id)
VALUES('b07e0b20-b7b4-11ec-aa42-bb7fafee3cf6', 'Ana Maria', '72769587013', 'anamaria@gmail.com', '2fcc8fec-b7b4-11ec-b2c6-23509029e07d');

INSERT INTO public.client_tab
(id, clientname, cpf, email, adress_id)
VALUES('c01931ae-b7b4-11ec-a4ea-e7506cc5a06e', 'Mário José', '23695918039', 'mariojose@gmail.com', '82f54c68-b7b4-11ec-be88-130b4cbe5ca0');

INSERT INTO public.client_tab
(id, clientname, cpf, email, adress_id)
VALUES('c7043428-b7b4-11ec-9bc0-4722d4feae7b', 'Sandra Pires', '06673603011', 'sandrapires@gmail.com', '6689e53e-b7b4-11ec-8d99-e3bbaef2ae15');