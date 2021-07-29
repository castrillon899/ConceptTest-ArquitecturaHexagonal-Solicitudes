FROM node:alpine AS builder

WORKDIR /app

COPY . .

RUN npm install && npm run build --prod

FROM nginx:alpine

COPY --from=builder /app/dist/* /usr/share/nginx/html/

RUN rm /etc/nginx/conf.d/default.conf

COPY default.conf /etc/nginx/conf.d

ARG TZ='America/Bogota'
ENV TZ=${TZ}

RUN cp /usr/share/zoneinfo/${TZ} /etc/localtime && echo ${TZ} > /etc/timezone