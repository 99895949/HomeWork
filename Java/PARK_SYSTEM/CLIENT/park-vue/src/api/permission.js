import request from "@/utils/request"

export function getAll() {
    return request({
        url: "/permissionname",
        method: "get"
    })
}

