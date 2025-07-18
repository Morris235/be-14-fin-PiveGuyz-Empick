import dayjs from 'dayjs'

// 근태 테이블 헤더 정의
export const ATTENDANCE_HEADERS = [
    { title: '근무 날짜', key: 'workDate', sortable: true },
    { title: '출근 시간', key: 'checkInTime', sortable: true },
    { title: '퇴근 시간', key: 'checkOutTime', sortable: true },
    { title: '근무 시간', key: 'workHours', sortable: true },
    { title: '상태', key: 'status', sortable: true },
    { title: '비고', key: 'note', sortable: false }
]

// 근태 상태 색상 매핑
export const ATTENDANCE_STATUS_COLORS = {
    present: 'success',
    late: 'warning',
    early: 'info',
    absent: 'error',
    vacation: 'secondary'
}

// 근태 상태 라벨 매핑
export const ATTENDANCE_STATUS_LABELS = {
    present: '정상',
    late: '지각',
    early: '조퇴',
    absent: '결근',
    vacation: '휴가'
}

// 날짜 포맷팅 함수
export const formatDate = (date) => {
    if (!date) return '-'
    return dayjs(date).format('YYYY-MM-DD')
}

// 시간 포맷팅 함수
export const formatTime = (time) => {
    if (!time) return '-'
    return dayjs(time).format('HH:mm')
}

// 근무 시간 포맷팅 함수
export const formatWorkHours = (hours) => {
    if (!hours) return '-'
    if (typeof hours === 'string') {
        const numHours = parseFloat(hours)
        if (isNaN(numHours)) return '-'
        return `${numHours.toFixed(1)}시간`
    }
    return `${hours.toFixed(1)}시간`
}

// 근태 상태 색상 반환 함수
export const getAttendanceStatusColor = (status) => {
    return ATTENDANCE_STATUS_COLORS[status] || 'grey'
}

// 근태 상태 라벨 반환 함수
export const getAttendanceStatusLabel = (status) => {
    return ATTENDANCE_STATUS_LABELS[status] || '미지정'
} 