# Hood Square

A social network for gated communities (estates) in Uganda. Hood Square helps neighbors share updates, report incidents, find lost items, and connect with trusted services within their community.

## Live Demo

- Frontend: https://hood-square-frontend.onrender.com
- Demo access: for security, this repository does not publish passwords. Use the app's registration flow to create an account, or request demo credentials from the maintainer.

## What's In This Repo

This repository currently contains the backend API (Spring Boot) inside `hoodSquare/`.

Key modules implemented:

- Auth: JWT-based authentication (`/auth/register`, `/auth/login`, `/auth/me`)
- Security alerts: report and list alerts (`/alerts`) with optional image upload
- Lost & Found: post and list lost items (`/lost`) + claim workflow (`/claim`)
- Community services: post and browse skills/services (`/services`)
- Realtime chat: STOMP over WebSocket (`/ws`, `/app/*`, `/topic/*`)

## Tech Stack

- Java 25
- Spring Boot (WebMVC, Security, WebSocket)
- PostgreSQL + Spring Data JPA (Hibernate)
- JWT (jjwt)
- OpenAPI UI via SpringDoc

## Run Locally (Backend)

### Prerequisites

- Java 25
- Maven
- PostgreSQL

### Environment Variables

The backend reads configuration from environment variables:

- `SPRING_DATASOURCE_URL` (example: `jdbc:postgresql://localhost:5432/hoodsquare`)
- `SPRING_DATASOURCE_USERNAME`
- `SPRING_DATASOURCE_PASSWORD`
- `JWT_SECRET`
- `PORT` (optional, defaults to `8080`)

### Start The API

```bash
cd hoodSquare
mvn spring-boot:run
```

The API will be available at `http://localhost:8080` unless you set `PORT`.

### Docker

```bash
docker build -t hood-square-api ./hoodSquare
docker run --rm -p 8085:8085 \
  -e PORT=8085 \
  -e SPRING_DATASOURCE_URL="jdbc:postgresql://host.docker.internal:5432/hoodsquare" \
  -e SPRING_DATASOURCE_USERNAME="postgres" \
  -e SPRING_DATASOURCE_PASSWORD="postgres" \
  -e JWT_SECRET="change-me" \
  hood-square-api
```

## API Notes

- Protected routes require an `Authorization: Bearer <token>` header (token returned by `/auth/login`).
- WebSocket endpoint: `/ws` (SockJS enabled). App destinations use `/app/*`, broadcasts go to `/topic/*`.

## Contributing

Issues and pull requests are welcome. If you plan to change endpoints or data models, please include a short note describing the impact on the frontend.

