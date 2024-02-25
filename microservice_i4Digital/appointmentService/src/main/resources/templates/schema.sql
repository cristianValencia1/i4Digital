CREATE TABLE IF NOT EXISTS i4_specialists.appointment (
	id uuid NOT NULL DEFAULT gen_random_uuid(),
	"name" varchar NOT NULL,
	description varchar NULL,
	duration_minutes integer NOT NULL,
	color_hex_code varchar NOT NULL,
	CONSTRAINT appointment_pk PRIMARY KEY (id)
);
