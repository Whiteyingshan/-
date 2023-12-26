const fs = require('fs')
const parse = require('csv-parser')

const tokens = {
  admin: {
    token: 'admin-token'
  },
  editor: {
    token: 'editor-token'
  }
}

const users = {
  'admin-token': {
    roles: ['admin'],
    introduction: 'I am a super administrator',
    avatar: 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',
    name: 'Admin',
    password: '123456'
  },
  'editor-token': {
    roles: ['editor'],
    introduction: 'I am an editor',
    avatar: 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',
    name: 'Editor',
    password: '88888888'
  }
}

// 导出 Mock 数据到 CSV 文件
function exportMockDataToCSV(mockData, filePath) {
  const csvData = Object.keys(mockData).map(key => {
    const user = mockData[key]
    return {
      roles: JSON.stringify(user.roles),
      introduction: user.introduction,
      avatar: user.avatar,
      name: user.name,
      password: user.password
    }
  })

  const csvHeaders = ['roles', 'introduction', 'avatar', 'name', 'password']

  const csvContent = csvData.map(item =>
    csvHeaders.map(header => JSON.stringify(item[header])).join(',')
  )

  const csvResult = [csvHeaders.join(','), ...csvContent].join('\n')

  fs.writeFileSync(filePath, csvResult, 'utf-8')

  console.log(`Mock data exported to ${filePath}`)
}

// 导出模拟数据到 CSV 文件
exportMockDataToCSV(users, 'user_mock_data.csv')

module.exports = [
  // user login
  {
    url: '/vue-element-admin/user/login',
    type: 'post',
    response: config => {
      const { username } = config.body
      const token = tokens[username]

      // mock error
      if (!token) {
        return {
          code: 60204,
          message: 'Account and password are incorrect.'
        }
      }

      return {
        code: 20000,
        data: token
      }
    }
  },

  // get user info
  {
    url: '/vue-element-admin/user/info\.*',
    type: 'get',
    response: config => {
      const { token } = config.query
      const info = users[token]

      // mock error
      if (!info) {
        return {
          code: 50008,
          message: 'Login failed, unable to get user details.'
        }
      }

      return {
        code: 20000,
        data: info
      }
    }
  },

  // user logout
  {
    url: '/vue-element-admin/user/logout',
    type: 'post',
    response: _ => {
      return {
        code: 20000,
        data: 'success'
      }
    }
  }
]
