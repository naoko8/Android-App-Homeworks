package com.example.task_7

interface CallBack {
        fun onSuccess(response: String) {}
        fun onFailed(errorMessage: String) {}
}