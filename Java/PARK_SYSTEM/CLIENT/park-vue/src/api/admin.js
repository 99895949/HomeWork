import request from "@/utils/request"

export function add(admin) {
    return request({
        url: "/admin/admin",
        method: "post",
        data: admin
    })
}

export function update(admin) {
    return request({
        url: "/admin/admin",
        method: "put",
        data: admin
    })
}

export function remove(admin) {
    return request({
        url: "/admin/admin/" + admin.adminId,
        method: "delete"
    })
}

export function getAllOperators() {
    return request({
        url: "/admin/operator",
        method: "get"
    })
}

export function getAllAdmins() {
    return request({
        url: "/admin/admin",
        method: "get"
    })
}

export function login(admin) {
    return request({
        url: "/admin/login",
        method: "post",
        data: admin
    })
}

