import request from "@/utils/request"


export function add(station) {
    return request({
        url: "/station/station",
        method: "post",
        data: station
    })
}

export function remove(id) {
    return request({
        url: "/station/station/" + id,
        method: "delete",
    })
}

export function update(station) {
    return request({
        url: "/station/station",
        method: "put",
        data: station
    })
}

export function getSmall() {
    return request({
        url: "/station/small",
        method: "get"
    })
}
export function getMiddle() {
    return request({
        url: "/station/middle",
        method: "get"
    })
}
export function getLarge() {
    return request({
        url: "/station/large",
        method: "get"
    })
}

export function getAllFree() {
    return request({
        url: "/station/freestation",
        method: "get"
    })
}

export function getAll(page, size) {
    return request({
        url: "/station/station",
        method: "get",
        params: {
            page: page,
            size: size
        }
    })
}